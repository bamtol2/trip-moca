<template>
  <div class="search-form">
    <div class="search-group">
      <div>
        <p class="text1">당신만의 힙한 여행,<br />여기서 시작해요✨</p>
      </div>
      <br />
      <div>
        <p class="text2">출발일자</p>
        <Datepicker
          v-model="startDate"
          :min-date="new Date()"
          :enable-time-picker="false"
          :format="formatDate"

          :auto-apply="true"
          locale="ko"
          :clearable="false"
          @update:model-value="updateStartDate"
          menuClassName="custom-datepicker-menu"
          :dark="true"
        >
          <template #trigger>
            <div class="date-trigger" :class="{ 'has-value': startDate }">
              {{ startDate ? formatDate(startDate) : "" }}
            </div>
          </template>
        </Datepicker>
      </div>
      <div>
        <p class="text2">도착일자</p>
        <Datepicker
          v-model="endDate"
          :min-date="startDate || new Date()"
          :enable-time-picker="false"
          :format="formatDate"

          :auto-apply="true"
          locale="ko"
          :clearable="false"
          menuClassName="custom-datepicker-menu"
          :dark="true"
        >
          <template #trigger>
            <div class="date-trigger" :class="{ 'has-value': endDate }">
              {{ endDate ? formatDate(endDate) : "" }}
            </div>
          </template>
        </Datepicker>
      </div>
      <div>
        <p class="text2">지역</p>
        <select class="select-location" v-model="selectedArea">
          <!-- <option value="">지역을 선택하세요</option> -->
          <option v-for="region in regions" :key="region.code" :value="region.code">
            {{ region.name }}
          </option>
        </select>
      </div>

      <!-- 버튼을 search-group 안으로 이동 -->
      <button class="search-submit" @click="handleSubmit" :disabled="!isFormValid">
        출 발 하 기
        <div class="star-1">
          <svg
            xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 0 784.11 815.53"
            style="
              shape-rendering: geometricPrecision;
              text-rendering: geometricPrecision;
              image-rendering: optimizeQuality;
              fill-rule: evenodd;
              clip-rule: evenodd;
            "
            version="1.1"
            xml:space="preserve"
            xmlns="http://www.w3.org/2000/svg"
          >
            <defs></defs>
            <g id="Layer_x0020_1">
              <metadata id="CorelCorpID_0Corel-Layer"></metadata>
              <path
                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z"
                class="fil0"
              ></path>
            </g>
          </svg>
        </div>
        <div class="star-2">
          <svg
            xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 0 784.11 815.53"
            style="
              shape-rendering: geometricPrecision;
              text-rendering: geometricPrecision;
              image-rendering: optimizeQuality;
              fill-rule: evenodd;
              clip-rule: evenodd;
            "
            version="1.1"
            xml:space="preserve"
            xmlns="http://www.w3.org/2000/svg"
          >
            <defs></defs>
            <g id="Layer_x0020_1">
              <metadata id="CorelCorpID_0Corel-Layer"></metadata>
              <path
                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z"
                class="fil0"
              ></path>
            </g>
          </svg>
        </div>
        <div class="star-3">
          <svg
            xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 0 784.11 815.53"
            style="
              shape-rendering: geometricPrecision;
              text-rendering: geometricPrecision;
              image-rendering: optimizeQuality;
              fill-rule: evenodd;
              clip-rule: evenodd;
            "
            version="1.1"
            xml:space="preserve"
            xmlns="http://www.w3.org/2000/svg"
          >
            <defs></defs>
            <g id="Layer_x0020_1">
              <metadata id="CorelCorpID_0Corel-Layer"></metadata>
              <path
                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z"
                class="fil0"
              ></path>
            </g>
          </svg>
        </div>
        <div class="star-4">
          <svg
            xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 0 784.11 815.53"
            style="
              shape-rendering: geometricPrecision;
              text-rendering: geometricPrecision;
              image-rendering: optimizeQuality;
              fill-rule: evenodd;
              clip-rule: evenodd;
            "
            version="1.1"
            xml:space="preserve"
            xmlns="http://www.w3.org/2000/svg"
          >
            <defs></defs>
            <g id="Layer_x0020_1">
              <metadata id="CorelCorpID_0Corel-Layer"></metadata>
              <path
                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z"
                class="fil0"
              ></path>
            </g>
          </svg>
        </div>
        <div class="star-5">
          <svg
            xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 0 784.11 815.53"
            style="
              shape-rendering: geometricPrecision;
              text-rendering: geometricPrecision;
              image-rendering: optimizeQuality;
              fill-rule: evenodd;
              clip-rule: evenodd;
            "
            version="1.1"
            xml:space="preserve"
            xmlns="http://www.w3.org/2000/svg"
          >
            <defs></defs>
            <g id="Layer_x0020_1">
              <metadata id="CorelCorpID_0Corel-Layer"></metadata>
              <path
                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z"
                class="fil0"
              ></path>
            </g>
          </svg>
        </div>
        <div class="star-6">
          <svg
            xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 0 784.11 815.53"
            style="
              shape-rendering: geometricPrecision;
              text-rendering: geometricPrecision;
              image-rendering: optimizeQuality;
              fill-rule: evenodd;
              clip-rule: evenodd;
            "
            version="1.1"
            xml:space="preserve"
            xmlns="http://www.w3.org/2000/svg"
          >
            <defs></defs>
            <g id="Layer_x0020_1">
              <metadata id="CorelCorpID_0Corel-Layer"></metadata>
              <path
                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z"
                class="fil0"
              ></path>
            </g>
          </svg>
        </div>
      </button>
    </div>
  </div>

  <!-- 로딩 오버레이 - fixed positioning으로 변경 -->
  <div v-if="isLoading" class="loading-overlay">
    <div class="loading-content">
      <div class="spinner"></div>
      <h2 class="loading-text">AI가 최적의 여행 계획을 만들고 있습니다</h2>
      <p class="loading-description">잠시만 기다려주세요...</p>
      <p class="loading-timer">{{ formattedTime }}</p>
    </div>
  </div>

  <!-- welcomeAnimation 추가 -->
  <welcomeAnimation v-if="showAnimation" @animation-complete="handleAnimationComplete" />
</template>

<script setup>
import { ref, computed } from "vue";
import { useRouter } from "vue-router";
import { useAiRecommendPlanStore } from "@/store/aiRecommendPlanStore";
import welcomeAnimation from "@/views/animationView/welcomeAnimation.vue";
import Datepicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

const emit = defineEmits(["ai-loading-complete"]);

const router = useRouter();
const aiRecommendStore = useAiRecommendPlanStore();

const startDate = ref("");
const endDate = ref("");
const selectedArea = ref("");
// const showStartPlaceholder = ref(true);
// const showEndPlaceholder = ref(true);
const isLoading = ref(false);
const showAnimation = ref(false);
const elapsedSeconds = ref(0);
let timer = null;

const today = new Date().toISOString().split("T")[0];

// 날짜 포맷 함수
const formatDate = (date) => {
  if (!date) return "";
  const d = new Date(date);
  const year = d.getFullYear();
  const month = String(d.getMonth() + 1).padStart(2, "0");
  const day = String(d.getDate()).padStart(2, "0");
  return `${year}-${month}-${day}`;
};

// startDate가 변경될 때 endDate 검증
const updateStartDate = (newDate) => {
  if (endDate.value && new Date(endDate.value) < new Date(newDate)) {
    endDate.value = null;
  }
};

const regions = [
  { code: "1", name: "서울" },
  { code: "2", name: "인천" },
  { code: "3", name: "대전" },
  { code: "4", name: "대구" },
  { code: "5", name: "광주" },
  { code: "6", name: "부산" },
  { code: "7", name: "울산" },
  { code: "8", name: "세종" },
  { code: "31", name: "경기도" },
  { code: "32", name: "강원도" },
  { code: "33", name: "충청북도" },
  { code: "34", name: "충청남도" },
  { code: "35", name: "경상북도" },
  { code: "36", name: "경상남도" },
  { code: "37", name: "전라북도" },
  { code: "38", name: "전라남도" },
  { code: "39", name: "제주도" },
];

const isFormValid = computed(() => {
  return (
    startDate.value &&
    endDate.value &&
    selectedArea.value &&
    new Date(endDate.value) >= new Date(startDate.value)
  );
});

const formattedTime = computed(() => {
  const minutes = Math.floor(elapsedSeconds.value / 60);
  const seconds = elapsedSeconds.value % 60;
  return `${minutes}:${seconds.toString().padStart(2, "0")}`;
});

const startTimer = () => {
  elapsedSeconds.value = 0;
  timer = setInterval(() => {
    elapsedSeconds.value++;
  }, 1000);
};

const stopTimer = () => {
  if (timer) {
    clearInterval(timer);
    timer = null;
  }
};

const handleSubmit = async () => {
  try {
    if (!isFormValid.value) {
      alert("모든 항목을 올바르게 입력해주세요.");
      return;
    }

    isLoading.value = true;
    emit('ai-loading', true);
    startTimer();

    const start = new Date(startDate.value);
    const end = new Date(endDate.value);
    const daysDiff = Math.ceil((end - start) / (1000 * 60 * 60 * 24)) + 1;

    // aiRecommendStore 초기화
    aiRecommendStore.resetStore();

    // 선택된 목적지 정보 저장
    const selectedRegion = regions.find((r) => r.code === selectedArea.value);
    aiRecommendStore.$patch({
      selectedDestination: {
        id: null,
        areaCode: selectedArea.value,
        areaName: selectedRegion.name,
        title: selectedRegion.name,
        numberOfDays: daysDiff,
        info: "",
      },
    });

    // AI 여행 계획 생성
    await aiRecommendStore.generateAiPlan();

    // 최소 로딩 시간 보장
    const minLoadingTime = new Promise((resolve) => setTimeout(resolve, 2000));
    await minLoadingTime;

    // 로딩 중단 및 welcomeAnimation 표시
    stopTimer();
    isLoading.value = false;
    showAnimation.value = true;
  } catch (error) {
    console.error("Error creating plan:", error);
    alert("여행 계획 생성 중 오류가 발생했습니다.");
    stopTimer();
    isLoading.value = false;
  }
};

// welcomeAnimation 완료 핸들러 추가
const handleAnimationComplete = async () => {
  showAnimation.value = false;
  // 애니메이션 완료 후 페이지 이동
  emit('ai-loading', false);
  await router.push({
    name: "modifyRecommendTour",
    params: { id: selectedArea.value },
  });
};
</script>

<style scoped>
.select-location {
  text-align: center;
  width: 385px;
  height: 48px;
  border: 1px solid #ffffff;
}

.select-location:hover {
  cursor: pointer;
  border: 1px solid #ecb27b;
}

.select-location .search-group {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 10px;
}

.h1-text {
  font-family: "EliceDigitalBaeum_Regular";
  font-size: 56px;
  text-align: left;
}

.text1 {
  font-family: "EliceDigitalBaeum_Regular";
  text-align: left;
  font-size: 24px;
}

.text2 {
  font-family: "EliceDigitalBaeum_Regular";
  text-align: left;
  margin-bottom: 5px;
}

.search-submit {
  position: relative;
  padding: 12px 35px;
  background: var(--color);
  font-size: 17px;
  font-weight: 500;
  color: #ffffff;
  border: 1px solid #ffffff;
  border-radius: 6px;
  box-shadow: 0 0 0 #fec1958c;
  transition: all 0.3s ease-in-out;
  cursor: pointer;
  margin-top: 55px;
  width: 100%;
}

button {
  position: relative;
  padding: 12px 35px;
  background: var(--color);
  font-size: 17px;
  font-weight: 500;
  color: #181818;
  border: 3px solid var(--color);
  border-radius: 6px;
  box-shadow: 0 0 0 #ff6a008c;
  transition: all 0.3s ease-in-out;
  cursor: pointer;
}

.star-1 {
  position: absolute;
  top: 20%;
  left: 20%;
  width: 25px;
  height: auto;
  filter: drop-shadow(0 0 0 #ecb27b);
  z-index: -5;
  transition: all 1s cubic-bezier(0.05, 0.83, 0.43, 0.96);
}

.star-2 {
  position: absolute;
  top: 45%;
  left: 45%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 0 #ecb27b);
  z-index: -5;
  transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-3 {
  position: absolute;
  top: 40%;
  left: 40%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 0 #ecb27b);
  z-index: -5;
  transition: all 1s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-4 {
  position: absolute;
  top: 20%;
  left: 40%;
  width: 8px;
  height: auto;
  filter: drop-shadow(0 0 0 #ecb27b);
  z-index: -5;
  transition: all 0.8s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-5 {
  position: absolute;
  top: 25%;
  left: 45%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 0 #ecb27b);
  z-index: -5;
  transition: all 0.6s cubic-bezier(0, 0.4, 0, 1.01);
}

.star-6 {
  position: absolute;
  top: 5%;
  left: 50%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 0 #ecb27b);
  z-index: -5;
  transition: all 0.8s ease;
}

button:hover {
  background: transparent;
  color: var(--color);
  box-shadow: 0 0 25px #fec1958c;
}

button:hover .star-1 {
  position: absolute;
  top: -80%;
  left: -30%;
  width: 25px;
  height: auto;
  filter: drop-shadow(0 0 10px #ecb27b);
  z-index: 2;
}

button:hover .star-2 {
  position: absolute;
  top: -25%;
  left: 10%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 10px #ecb27b);
  z-index: 2;
}

button:hover .star-3 {
  position: absolute;
  top: 55%;
  left: 25%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 10px #ecb27b);
  z-index: 2;
}

button:hover .star-4 {
  position: absolute;
  top: 30%;
  left: 80%;
  width: 8px;
  height: auto;
  filter: drop-shadow(0 0 10px #ecb27b);
  z-index: 2;
}

button:hover .star-5 {
  position: absolute;
  top: 25%;
  left: 115%;
  width: 15px;
  height: auto;
  filter: drop-shadow(0 0 10px #ecb27b);
  z-index: 2;
}

button:hover .star-6 {
  position: absolute;
  top: 5%;
  left: 60%;
  width: 5px;
  height: auto;
  filter: drop-shadow(0 0 10px #ecb27b);
  z-index: 2;
}

.fil0 {
  fill: #ecb27b;
}

.search-submit:disabled {
  cursor: not-allowed;
  opacity: 0.7;
}

.search-submit:disabled:hover {
  color: #ffffff;
  box-shadow: none;
}

.search-submit:disabled .star-1,
.search-submit:disabled .star-2,
.search-submit:disabled .star-3,
.search-submit:disabled .star-4,
.search-submit:disabled .star-5,
.search-submit:disabled .star-6 {
  display: none;
}

input[type="date"],
select {
  background-color: transparent;
  color: #ffffff;
  font-family: "EliceDigitalBaeum_Regular";
}

input[type="date"]::-webkit-calendar-picker-indicator {
  filter: invert(1);
  cursor: pointer;
}

select option {
  background-color: #333;
  color: #ffffff;
}
/* 로딩오버레이 */
.fullscreen-animation {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: 9999;
  background-color: white;
}
.loading-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.7);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 9999;
}
.welcome-animation {
  z-index: 9999;
  position: fixed;
}

.loading-content {
  text-align: center;
  color: white;
  padding: 2rem;
}

.loading-text {
  font-family: "EliceDigitalBaeum_Bold";
  font-size: 1.5rem;
  margin: 1rem 0;
}

.loading-description {
  font-family: "EliceDigitalBaeum_Regular";
  margin-bottom: 0.5rem;
}

.loading-timer {
  font-family: "Roboto Mono";
  font-size: 1.2rem;
}

.spinner {
  border: 4px solid #f3f3f3;
  border-top: 4px solid #ecb27b;
  border-radius: 50%;
  width: 50px;
  height: 50px;
  animation: spin 1s linear infinite;
  margin: 0 auto;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

:deep(.custom-datepicker-menu) {
  background-color: #2a2a2a !important;
  border: 1px solid #3a3a3a !important;
  border-radius: 6px !important;
  font-family: "EliceDigitalBaeum_Regular" !important;
}

:deep(.dp__main) {
  font-family: var(--dp-font-family);
  user-select: none;
  box-sizing: border-box;
  position: relative;
  width: 100%;
  margin-bottom: 20px;
}

:deep(.dp__active_date) {
  background-color: #ecb27b !important;
  color: #ffffff !important;
}

:deep(.dp__date_hover) {
  background-color: rgba(236, 178, 123, 0.2) !important;
}

:deep(.dp__today) {
  border: 1px solid #ecb27b !important;
}

:deep(.dp__arrow_bottom) {
  border-top: 2px solid #ffffff !important;
  border-right: 2px solid #ffffff !important;
}

:deep(.dp__month_year_select) {
  color: #ffffff !important;
}

:deep(.dp__menu_index) {
  font-family: "Pretendard-Light";
}

:deep(.dp__calendar_header) {
  color: #ffffff !important;
}

:deep(.dp__cell_inner) {
  color: #ffffff !important;
}

:deep(.dp__disabled) {
  color: #666666 !important;
}

.date-trigger {
  width: 385px;
  height: 48px;
  background-color: transparent;
  border: 1px solid #ffffff;
  border-radius: 6px;
  color: #ffffff80;
  font-family: "EliceDigitalBaeum_Regular";
  padding: 0 12px;
  font-size: 16px;
  display: flex;
  align-items: center;
  cursor: pointer;
  transition: all 0.3s ease;
  justify-content: center;
}

.date-trigger.has-value {
  color: #ffffff;
}

.date-trigger:hover {
  border-color: #ecb27b;
}

:deep(.dp__input) {
  color: #ffffff !important;
}

:deep(.dp__input_icon) {
  color: #ffffff !important;
}

:deep(.dp__overlay) {
  background-color: rgba(0, 0, 0, 0.7) !important;
}
</style>
