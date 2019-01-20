<template>
  <div class="list driver__list col-md-10">
     <h4> Driver List </h4>
     <table class="table table-borderless table-hover">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Name</th>
          <th scope="col">Balance</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="driver in drivers" :key="driver.id" @click="onDriverSelect(driver.id)">
          <th scope="row">{{driver.id}}</th>
          <td>{{driver.name}}</td>
          <td>{{driver.balance}}</td>
          <td>{{driver.status.toLowerCase().charAt(0).toUpperCase()+driver.status.toLowerCase().slice(1)}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
  name: 'DriverList',
  data(){
    return {
        drivers:[]
    };
  },
  mounted(){
    axios.get(`${API_URL}/drivers`).then(
      response => (this.drivers=response.data) 
      ).catch(e=>{
        this.error.push(e);
    })
  },
  methods:{
    onDriverSelect(id){
      this.$router.push({name:'driversListDetail',params:{id:id}})
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
