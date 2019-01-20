<template>
  <div class="list payment__list col-md-10">
     <h4>Payment Method List </h4>
     <table class="table table-borderless table-hover">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Name</th>
          <th scope="col">Type</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="payment in payments" :key="payment.id">
          <th scope="row">{{payment.id}}</th>
          <td>{{payment.name}}</td>
          <td>{{payment.type}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
  name: 'paymentList',
  data(){
    return {
        payments:[]
    };
  },
  mounted(){
    axios.get(`${API_URL}/payment-method`).then(
      response => (this.payments=response.data) 
      ).catch(e=>{
        this.error.push(e);
    })
  },
  methods:{
    onpaymentSelect(id){
      this.$router.push({name:'paymentsListDetail',params:{id:id}})
    }
  }
}
</script>

<style scoped>
 .list{
   margin : 20px auto;
 }

 h4{
   margin: 20px 0;
 }
</style>
