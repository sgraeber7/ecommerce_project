<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Our Categories</h3>
        <router-link id="add-category" :to="{ name: 'AddCategory' }" v-show="$route.name == 'AdminCategory'">
          <button class="btn">Add a new Category</button>
        </router-link>
      </div>
    </div>
    <div class="row">
      <div v-for="category of categories" :key="category.id"
        class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
        <CategoryBox :category="category">
        </CategoryBox>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import CategoryBox from '../../components/category/CategoryBox';

export default {
  name: 'CategoryView',
  components: { CategoryBox },
  data() {
    return {
      // baseUrl: "https://limitless-lake-55070.herokuapp.com/",
      categories: null,
    }
  },
  methods: {
    async getCategories() {
      // fetch categories
      await axios.get(this.$root.baseUrl + "category/")
        .then(res => this.categories = res.data)
        .catch(err => console.log(err))
    }
  },
  mounted() {
    this.getCategories();
    console.log(this.$root.baseUrl);
  }
}
</script>


<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}

#add-category {
  float: right;
  font-weight: 500;
}
</style>