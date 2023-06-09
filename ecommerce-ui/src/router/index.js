import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from '../views/category/AddCategory'
import CategoryView from '../views/category/CategoryView'
import EditCategory from '../views/category/EditCategory'
import AddProduct from '../views/product/AddProduct'
import ProductView from '../views/product/ProductView'
import EditProduct from '../views/product/EditProduct'
import ShowDetails from '../views/product/ShowDetails'
import SignupView from '../views/SignupView'
import SigninView from "../views/SigninView"
import WishList from "../views/product/WishList";
import Success from "../views/payment/Success";
import Failed from "../views/payment/Failed";
import CheckoutView from "../views/checkout/CheckoutView";
import CartView from "../views/cart/CartView";
import OrderHistory from "../views/order/OrderHistory";
import OrderDetails from "../views/order/OrderDetails";

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  // {
  //   path: '/about',
  //   name: 'About',
  //   component: AboutView
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // },
  {
    path: '/admin/category/add',
    name: "AddCategory",
    component: AddCategory,
  },
  {
    path: "/admin/category",
    name: "AdminCategory",
    component: CategoryView,
  },
  {
    path: "/admin/category/:id",
    name: "EditCategory",
    component: EditCategory,
  },
  {
    path: "/admin/product/add",
    name: "AddProduct",
    component: AddProduct,
  },
  {
    path: "/admin/product",
    name: "AdminProduct",
    component: ProductView,
  },
  {
    path: "/admin/product/:id",
    name: "EditProduct",
    component: EditProduct,
  },
  {
    path : '/product/show/:id',
    name : 'ShowDetails',
    component: ShowDetails
  },
  {
    path: '/signup',
    name: 'SignupView',
    component: SignupView
  },
  {
    path: '/signin',
    name: 'SigninView',
    component: SigninView
  },
  {
    path: '/wishlist',
    name: 'WishList',
    component: WishList
  },
  {
    path : '/cart',
    name : 'CartView',
    component : CartView
  },
  {
    path: '/payment/success',
    name: 'PaymentSuccess',
    component:Success
  },
  {
    path: '/payment/failed',
    name: 'FailedPayment',
    component:Failed
  },
  {
    path : '/checkout',
    name : 'CheckoutView',
    component : CheckoutView
  },
  {
    path: '/orders',
    name: 'OrderHistory',
    component: OrderHistory
  },
  {
    path:'/order/:id',
    name:'OrderDetails',
    component: OrderDetails
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

// Global navigation guard
router.beforeEach((to, from, next) => {
  window.scrollTo(0, 0); // Scrolls to the top of the page
  next();
});


export default router