<template>
  <div class="list customer__list col-md-10">
     <h4> Customer List </h4>
      <div>
          <button class="btn btn-primary" @click="addCustomer">Add New Customer</button>
      </div>
     <table class="table table-borderless table-hover">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Name</th>
          <th scope="col">Balance</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="customer in customers" :key="customer.id" @click="oncustomerSelect(customer.id)">
          <th scope="row">{{customer.id}}</th>
          <td>{{customer.name}}</td>
          <td>{{customer.balance}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
  name: 'customerList',
  data(){
    return {
        customers:[]
    };
  },
  mounted(){
    axios.get(`${API_URL}/customers`).then(
      response => (this.customers=response.data) 
      ).catch(e=>{
        this.error.push(e);
    })
  },
  methods:{
    oncustomerSelect(id){
      this.$router.push({name:'customersListDetail',params:{id:id}})
    },
    addCustomer(){
      this.$router.push({name:'customersAdd'}); 
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

 .btn-primary{
   margin-bottom: 20px;
 }
</style>
