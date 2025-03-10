<template>
  <div class="layout-container">
    <navBar />
    <div class="content-wrapper" :class="{ collapsed: isCollapsed }">
      <!-- Left Sidebar -->
      <div class="steps-sidebar">
        <div class="steps-nav">
          <div class="step" @click="goToDateSelection">
            <div class="step-number">STEP 1</div>
            <div class="step-title">날짜 선택</div>
          </div>

          <div class="step" @click="checkDateAndNavigate">
            <div class="step-number">STEP 2</div>
            <div class="step-title">장소 선택</div>
          </div>

          <div
            class="step"
            :class="{ active: isStep3Active }"
            @click="toggleStep3"
          >
            <div class="step-number">STEP 3</div>
            <div class="step-title">계획 생성</div>
          </div>
        </div>
      </div>

      <!-- Middle Section -->
      <div class="middle-section">
        <div class="toggle-button" @click="toggleCollapse">
          <i class="fa-solid fa-arrow-left"></i>
        </div>
        <div class="header">
          <h2>{{ name }}</h2>
          <p v-if="formattedDateRange" class="date-range">
            {{ formattedDateRange }}
          </p>
        </div>

        <div class="content-section">
          <div class="plan-form">
            <div class="form-group">
              <label for="planTitle">여행 제목</label>
              <input
                type="text"
                id="planTitle"
                v-model="planTitle"
                :placeholder="defaultTitle"
                class="plan-title-input"
              />
            </div>

            <!-- 대표 이미지 업로드 섹션 -->
            <div class="form-group">
              <label for="planProfileImg">나만의 여행지 사진</label>
              <div class="image-upload-container">
                <div
                  class="image-preview"
                  :class="{ 'has-image': previewUrl }"
                  @click="triggerFileInput"
                >
                  <img
                    v-if="previewUrl"
                    :src="previewUrl"
                    alt="여행 대표 이미지"
                    class="preview-image"
                  />
                  <div v-else class="upload-placeholder">
                    <i class="fa-solid fa-camera"></i>
                    <p>클릭하여 이미지 업로드</p>
                  </div>
                </div>
                <input
                  type="file"
                  ref="fileInput"
                  @change="handleImageUpload"
                  accept="image/*"
                  class="hidden-input"
                />
              </div>
            </div>

            <div class="daily-plans">
              <div
                v-for="(places, dayIndex) in selectedPlaces"
                :key="dayIndex"
                class="day-section"
              >
                <h3>
                  {{ dayIndex + 1 }}일차 {{ formatDate(getTripDate(dayIndex)) }}
                </h3>
                <div class="place-list">
                  <div
                    v-for="(place, placeIndex) in places"
                    :key="placeIndex"
                    class="place-item"
                  >
                    <div class="place-image">
                      <img
                        :src="getImageUrl(place.image1)"
                        :alt="place.title"
                      />
                    </div>
                    <div class="place-info">
                      <h4>{{ place.title }}</h4>
                      <p>{{ place.addr1 }}</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="action-buttons">
              <button @click="savePlan" class="save-button">계획 완료!</button>
            </div>
          </div>
        </div>
      </div>

      <!-- Map Section -->
      <div class="map-container">
        <Tmap
          ref="tmap"
          :latitude="latitude"
          :longitude="longitude"
          :selected-places-by-day="selectedPlaces"
          :selected-day="selectedDay"
          :show-all-days="true"
        />
      </div>
    </div>
  </div>
</template>

<script>
import { usePlanStore } from "@/store/planStore";
import { useAuthStore } from "@/store/auth";
import { showLoginModalFlag } from "@/eventBus";
import api from "@/plugins/axios";
import navBar from "@/components/navBar.vue";
import Tmap from "@/components/Tmap/Tmap.vue";

export default {
  name: "SavePlan",
  components: {
    navBar,
    Tmap,
  },
  props: {
    name: String,
    startDate: String,
    endDate: String,
    selectedPlaces: {
      type: Object,
      default: () => ({}),
    },
    latitude: Number,
    longitude: Number,
  },
  setup() {
    const planStore = usePlanStore();
    const authStore = useAuthStore();
    return { planStore, authStore };
  },
  data() {
    return {
      planTitle: "",
      selectedFile: null,
      previewUrl: null,
      selectedPlaces: {},
      isStep3Active: true,
      isCollapsed: false,
    };
  },
  computed: {
    defaultTitle() {
      return `${this.name || "국내"} 여행`;
    },
    formattedDateRange() {
      return this.planStore.dates.formattedDateRange;
    },
  },
  beforeUnmount() {
    // 컴포넌트 제거 시 미리보기 URL 정리
    if (this.previewUrl) {
      URL.revokeObjectURL(this.previewUrl);
    }
  },
  methods: {
    triggerFileInput() {
      this.$refs.fileInput.click();
    },

    async handleImageUpload(event) {
      const file = event.target.files[0];
      if (!file) return;

      try {
        // 파일 크기 체크 (5MB)
        if (file.size > 5 * 1024 * 1024) {
          throw new Error("이미지 크기는 5MB를 초과할 수 없습니다.");
        }

        // 파일 타입 체크
        if (!file.type.startsWith("image/")) {
          throw new Error("이미지 파일만 업로드할 수 있습니다.");
        }

        // 기존 URL 정리
        if (this.previewUrl) {
          URL.revokeObjectURL(this.previewUrl);
        }

        // 새 파일 설정
        this.selectedFile = file;
        this.previewUrl = URL.createObjectURL(file);
      } catch (error) {
        console.error("Image selection failed:", error);
        alert(error.message || "이미지 선택에 실패했습니다.");

        // 에러 발생 시 파일 입력 초기화
        if (this.$refs.fileInput) {
          this.$refs.fileInput.value = "";
        }
        this.selectedFile = null;
        this.previewUrl = null;
      }
    },

    removeImage() {
      if (this.previewUrl) {
        URL.revokeObjectURL(this.previewUrl);
      }
      this.selectedFile = null;
      this.previewUrl = null;
      if (this.$refs.fileInput) {
        this.$refs.fileInput.value = "";
      }
    },

    toggleStep3() {
      this.isStep3Active = !this.isStep3Active;
      if (!this.isStep3Active) {
        this.isCollapsed = true;
      } else {
        this.isCollapsed = false;
      }
      setTimeout(() => {
        this.updateMapSize();
      }, 300);
    },

    toggleCollapse() {
      this.isCollapsed = !this.isCollapsed;
      setTimeout(() => {
        if (this.$refs.tmap) {
          this.$refs.tmap.getMap().resize();
        }
      }, 300);
    },

    updateMapSize() {
      if (this.$refs.tmap) {
        this.$refs.tmap.getMap().resize();
        const center = new Tmapv2.LatLng(this.latitude, this.longitude);
        this.$refs.tmap.getMap().setCenter(center);
      }
    },

    goToDateSelection() {
      this.$router.push({
        name: "chooseDate",
        params: {
          name: this.name || this.$route.params.name || "제주도",
        },
        query: {
          startDate: this.localStartDate,
          endDate: this.localEndDate,
          id: this.$route.query.id,
        },
      });
    },

    checkDateAndNavigate() {
      this.$router.push({
        name: "choosePlace",
        params: {
          name: this.name || this.$route.params.name,
        },
        query: {
          startDate: this.localStartDate,
          endDate: this.localEndDate,
          id: this.$route.query.id,
        },
      });
    },

    formatDate(date) {
      if (!date) return "";
      const days = ["일", "월", "화", "수", "목", "금", "토"];
      return `(${days[date.getDay()]})`;
    },

    getTripDate(dayIndex) {
      if (!this.localStartDate) return null;
      const date = new Date(this.localStartDate);
      date.setDate(date.getDate() + dayIndex);
      return date;
    },

    getImageUrl(imageUrl) {
      return (
        imageUrl ||
        "https://enjoy-trip-static-files.s3.ap-northeast-2.amazonaws.com/no-image.png"
      );
    },

    async savePlan() {
      try {
        if (!this.planTitle && !this.defaultTitle) {
          throw new Error("여행 제목을 입력해주세요.");
        }

        if (!this.planStore.selectedPlaces.length) {
          throw new Error("최소 하나의 여행지를 선택해주세요.");
        }

        // 로그인 상태 체크
        if (!this.authStore.isAuthenticated) {
          showLoginModalFlag.value = true;

          const unwatch = this.$watch(
            () => this.authStore.isAuthenticated,
            async (newValue) => {
              if (newValue) {
                unwatch();
                await this.executeSavePlan();
              }
            }
          );
          return;
        }

        await this.executeSavePlan();
      } catch (error) {
        console.error("Error saving plan:", error);
        alert(
          error.message || "저장 중 오류가 발생했습니다. 다시 시도해주세요."
        );
      }
    },

    async executeSavePlan() {
      try {
        const formData = new FormData();

        const planData = {
          planTitle: this.planTitle || this.defaultTitle,
          areaCode: this.planStore.selectedDestination.areaCode,
          startDate: this.planStore.dates.startDate,
          endDate: this.planStore.dates.endDate,
          dayPlans: this.planStore.selectedPlaces.map((dayPlan) => ({
            day: dayPlan.day + 1,
            details: dayPlan.details.map((detail) => ({
              attractionId: detail.attractionId,
              sequence: detail.sequence + 1,
              memo: detail.memo,
            })),
          })),
        };

        formData.append(
          "plan",
          new Blob([JSON.stringify(planData)], { type: "application/json" })
        );

        if (this.selectedFile) {
          formData.append("image", this.selectedFile);
        }

        const response = await api.post("/domain/plans", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        });

        if (response.status === 200) {
          alert("여행 계획이 저장되었습니다!");
          this.planStore.resetStore();
          this.$router.push("/mypage");
        }
      } catch (error) {
        console.error("Error executing save plan:", error);
        alert(
          error.response?.data?.message ||
            "저장 중 오류가 발생했습니다. 다시 시도해주세요."
        );
      }
    },
  },
};
</script>

<style scoped>
.layout-container {
  display: flex;
  flex-direction: column;
  height: 100vh;
  overflow: hidden;
}

.content-wrapper {
  display: grid;
  grid-template-columns: 107px 370px minmax(0, 1fr);
  grid-template-rows: 1fr;
  height: calc(100vh - 64px);
  overflow: hidden;
  transition: all 0.3s ease;
  gap: 0;
}

.content-wrapper.collapsed {
  grid-template-columns: 200px 0 1fr;
}

/* Steps Sidebar Styles */
.steps-sidebar {
  background: white;
  height: 100%;
  position: relative;
  padding: 10px;
}

.steps-nav {
  text-align: center;
  font-family: "EliceDigitalBaeum_regular";
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.step {
  display: flex;
  flex-direction: column;
  padding: 16px;
  cursor: pointer;
  text-decoration: none;
  color: inherit;
  border-radius: 8px;
  transition: all 0.3s ease;
}

.step:hover,
.step.active {
  background-color: #f5f5f5;
}

.step-number {
  margin-bottom: 4px;
}
.step-title {
  font-size: 16px;
  color: #333;
}

.step-number,
.step-title {
  font-family: "EliceDigitalBaeum_Regular";
  font-size: 14px;
  color: #b4b4b4;
}

.step:hover .step-number,
.step:hover .step-title,
.step.active .step-number,
.step.active .step-title {
  color: #ecb27b;
}

/* Middle Section Styles */
.middle-section {
  position: relative;
  background: white;
  padding: 10px;
  border-right: 1px solid #eee;
  height: 100%;
  overflow-y: auto;
  transition: all 0.3s ease;
  min-width: 0;
}

.content-wrapper.collapsed .middle-section {
  padding: 0;
  overflow: hidden;
  opacity: 0;
}

.content-section {
  font-family: "Pretendard-Medium";
  flex: 1;
  padding: 20px;
  overflow-y: auto;
}

/* Form Styles */
.plan-form {
  display: flex;
  flex-direction: column;
  gap: 24px;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.form-group label {
  font-size: 16px;
  font-weight: 500;
  color: #333;
}

.plan-title-input {
  padding: 12px;
  border: 1px solid #ddd;
  border-radius: 8px;
  font-size: 16px;
  width: 100%;
}

/* Image Upload Styles */
.image-upload-container {
  width: 100%;
  max-width: 300px;
  margin: 0 auto;
}

.image-preview {
  width: 100%;
  height: 200px;
  border: 2px dashed #ddd;
  border-radius: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  overflow: hidden;
  transition: border-color 0.2s;
}

.image-preview:hover {
  border-color: #ecb27b;
}

.image-preview.has-image {
  border: none;
}

.preview-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.upload-placeholder {
  text-align: center;
  color: #666;
}

.upload-placeholder i {
  font-size: 48px;
  margin-bottom: 8px;
  color: #ddd;
}

.hidden-input {
  display: none;
}

/* Day Section Styles */
.daily-plans {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.day-section {
  background: #f8f9fa;
  border-radius: 8px;
  padding: 16px;
}

.day-section h3 {
  margin-bottom: 16px;
  font-size: 18px;
  color: #333;
}

/* Place Item Styles */
.place-list {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.place-item {
  display: flex;
  align-items: center;
  background: white;
  padding: 12px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.place-image {
  width: 80px;
  height: 80px;
  margin-right: 16px;
}

.place-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 8px;
}

.place-info {
  flex: 1;
}

.place-info h4 {
  font-size: 16px;
  color: #333;
  margin-bottom: 4px;
}

.place-info p {
  font-size: 14px;
  color: #666;
}

/* Button Styles */
.action-buttons {
  display: flex;
  gap: 12px;
  margin-top: 24px;
}

.save-button {
  width: 100%;
  padding: 12px 24px;
  border-radius: 8px;
  font-size: 16px;
  font-weight: 500;
  cursor: pointer;
  border: none;
  background: #ecb27b;
  color: white;
}

/* Toggle Button Styles */
.toggle-button {
  position: absolute;
  top: 20px;
  right: 10px;
  width: 32px;
  height: 32px;
  background-color: transparent;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  z-index: 100;
  transition: transform 0.3s ease;
}

.toggle-button i {
  font-size: 18px;
  color: #666;
  transition: color 0.3s ease;
}

.toggle-button:hover {
  transform: scale(1.1);
}

.toggle-button:hover i {
  color: #f57c00;
}

/* Map Container Styles */
.map-container {
  position: relative;
  width: 100%;
  height: 100%;
  min-height: 0;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  padding: 0;
  margin: 0;
}

.map-container :deep(.map-wrapper) {
  flex: 1;
  position: relative;
  width: 100%;
  height: 100%;
  min-height: 0;
}

/* Header Styles */
.header {
  margin-bottom: 20px;
}

.header h2 {
  font-family: "EliceDigitalBaeum_bold";
  font-size: 32px;
  margin-bottom: 8px;
}

.date-range {
  font-family: "EliceDigitalBaeum_bold";
  color: #ecb27b;
  font-size: 14px;
}

/* Scrollbar Styles */
.middle-section::-webkit-scrollbar {
  width: 8px;
}

.middle-section::-webkit-scrollbar-track {
  background: #f1f1f1;
  border-radius: 4px;
}

.middle-section::-webkit-scrollbar-thumb {
  background: #888;
  border-radius: 4px;
}

.middle-section::-webkit-scrollbar-thumb:hover {
  background: #555;
}

/* Save Button Hover Effect */
.save-button:hover {
  background: #6e6156;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
  transition: all 0.2s ease;
}

.save-button:active {
  transform: translateY(0);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

/* Font Styles */
.place-info h3,
h4 {
  font-family: "Pretendard-Bold";
  font-size: 1.125rem;
}

.place-info p {
  color: #b4b4b4;
  font-size: 14px;
  font-family: "Pretendard-Regular";
}
</style>