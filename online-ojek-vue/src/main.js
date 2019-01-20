import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import DriverList from './components/Driver/DriverList'
import DriverListDetail from './components/Driver/DriverListDetail'
import CustomerList from './components/Customer/CustomerList'
import CustomerAdd from './components/Customer/CustomerAdd'
import CustomerListDetail from './components/Customer/CustomerListDetail'
import BookingList from './components/Booking/BookingList'
import BookingAdd from './components/Booking/BookingAdd'
import PaymentMethodList from './components/Payment/PaymentMethodList'

Vue.use(VueRouter);

const router=new VueRouter({
  mode:'history',
  routes: [
    {
      path:'/drivers' ,
      name:'drivers',
      component: DriverList
    },
    {
      path:'/drivers/:id' ,
      name:'driversListDetail',
      component: DriverListDetail
    },
    {
      path:'/customers',
      name:'customers',
      component: CustomerList
    },
    {
      path:'/customers/add',
      name:'customersAdd',
      component: CustomerAdd
    },
    {
      path:'/customers/:id',
      name:'customersListDetail',
      component: CustomerListDetail
    },
    {
      path:'/bookings',
      name:'bookings',
      component: BookingList
    },
    {
      path:'/bookings/add',
      name:'bookingsAdd',
      component: BookingAdd
    },
    {
      path:'/payment-method',
      name:'payment-method',
      component: PaymentMethodList
    }
  ]
});

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
