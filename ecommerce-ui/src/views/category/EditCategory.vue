<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Edit Category</h3>
      </div>
    </div>

    <div class="row">
      <div class="col-3"></div>
      <div class="col-md-6 px-5 px-md-0">
        <form class="needs-validation" novalidate>
          <div class="form-group">
            <label>Category Name</label>
            <input type="text" class="form-control" v-model="categoryName" required>
            <div class="error-message">Please provide a category name.</div>
          </div>
          <div class="form-group">
            <label>Description</label>
            <input type="text" class="form-control" v-model="description" required>
            <div class="error-message">Please provide a description.</div>
          </div>
          <div class="form-group">
            <label>ImageURL</label>
            <input type="url" class="form-control" v-model="imageUrl" required>
            <div class="error-message">Please provide an imageURL.</div>
          </div>
          <button type="submit" class="btn btn-primary" @click="validateForm">Submit</button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>


<script>
let axios = require('axios')
import swal from 'sweetalert';

export default {
  data() {
    return {
      id: null,
      categoryName: null,
      description: null,
      imageUrl: null,
      categoryIndex: null,
    }
  },
  props: ["baseUrl", "categories"],
  methods: {
    validateForm(event) {
      event.preventDefault()
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var form = document.querySelector('.needs-validation');
      form.classList.add('was-validated');
      // form.noValidate = true;

      if (form.checkValidity()) {
        this.editCategory();
      }
    },

    async editCategory() {

      const updatedCategory = {
        id: this.id,
        categoryName: this.categoryName,
        description: this.description,
        imageUrl: this.imageUrl,
      }
      await axios({
        method: 'post',
        url: this.baseUrl + "category/update/" + this.id,
        data: JSON.stringify(updatedCategory),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(() => {
          swal({
            text: "Category Updated Successfully!",
            icon: "success",
            closeOnClickOutside: false,
          });
        })
        .catch(err => console.log(err));
    }

  },
  mounted() {
    this.id = this.$route.params.id;
    this.category = this.categories.filter(category => category.id == this.id)[0];
    this.categoryName = this.category.categoryName;
    this.description = this.category.description;
    this.imageUrl = this.category.imageUrl;
  }
}
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}

/* Valid input */
.was-validated .form-control:valid {
  border-color: #198754;
}

.was-validated input:valid:focus {
  outline-color: #198754;
}

/* Invalid input */
.was-validated input:invalid {
  border-color: #dc3545;
}

.was-validated input:invalid:focus {
  outline-color: #dc3545;
}

.was-validated :invalid~.error-message {
  display: block;
}

/* Show error message */
.error-message {
  display: none;
  color: #dc3545;
  margin-top: 0.25rem;
  font-size: 0.875em;
  font-style: italic;
}
</style>