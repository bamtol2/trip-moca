<template>
  <div class="mypage-plan">
    <div v-if="items.length === 0" class="empty-state">
      현재 여행 계획이 없습니다.
    </div>
    <div v-else class="grid-container">
      <div class="grid-item" v-for="(item, index) in items" :key="index"
        @click="viewPlanDetails(item.planId, item.areaCode)">
        <div class="card shadow-sm">
          <span class="img" :style="{ backgroundImage: `url(${item.planProfileImg})` }"></span>
          <div class="card-body">
            <font-awesome-icon :icon="['fas', 'location-dot']" :style="{ color: '#ECB27B' }" />
            <span class="location">{{ item.sidoName }}</span>
            <p class="card-text">
              <span class="title">{{ item.planTitle }}</span>
            </p>
            <p class="dates">{{ item.startDate }} ~ {{ item.endDate }}</p>
            <button class="delete-btn" @click.stop="deletePlan(item.planId)">
              <font-awesome-icon :icon="['fas', 'trash']" :style="{ color: '#B4B4B4' }" />
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { useMypageStore } from "@/store/mypageStore";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";

export default {
  setup() {
    const mypageStore = useMypageStore();
    const router = useRouter();
    const { userPlans } = storeToRefs(mypageStore);

    const viewPlanDetails = (planId, areaCode) => {
      router.push({
        name: 'DetailedTravelPlan',
        params: { id: planId, areaCode: areaCode }
      });
    };

    const deletePlan = async (planId) => {
      if (confirm("정말 이 여행 계획을 삭제하시겠습니까?")) {
        await mypageStore.deletePlan(planId);
      }
    };

    return {
      items: userPlans,
      deletePlan,
      viewPlanDetails
    };
  },
};
</script>

<style scoped>
.mypage-plan {
  padding: 20px 0;
}

/* 스크롤바 스타일링 */
.mypage-plan::-webkit-scrollbar {
  width: 8px;
}

.mypage-plan::-webkit-scrollbar-track {
  background: #f1f1f1;
  border-radius: 4px;
}

.mypage-plan::-webkit-scrollbar-thumb {
  background: #ecb27b;
  border-radius: 4px;
}

.mypage-plan::-webkit-scrollbar-thumb:hover {
  background: #dca06a;
}

.grid-container {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
  padding: 0 10px;
}

.grid-item {
  width: 100%;
}

.card {
  border-radius: 8px;
  overflow: hidden;
  transition: transform 0.2s;
  height: 100%;
  border: 1px solid #eee;
}

.card:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

.card .img {
  display: block;
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
}

.card-body {
  padding: 15px;
}

.card-text {
  margin: 10px 0px 0px 10px;
}

.location {
  font-family: "Pretendard-Medium";
  font-size: 18px;
  color: #000;
  margin: 10px 10px;
}

.card-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 10px;
}

.title {
  font-size: 28px;
  font-family: "Pretendard-SemiBold";
  margin: 0;
  color: #000;
}

.dates {
  font-size: 15px;
  font-family: "Pretendard-Regular";
  margin: 0 0 30px 10px;
  color: #777777;
}

.empty-state {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 200px;
  font-family: "Pretendard-Medium";
  font-size: 20px;
  color: #777777;
  text-align: center;
}

/* 반응형 그리드 */
@media (max-width: 1400px) {
  .grid-container {
    grid-template-columns: repeat(3, 1fr);
  }
}

@media (max-width: 1100px) {
  .grid-container {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .grid-container {
    grid-template-columns: 1fr;
  }
}
</style>
