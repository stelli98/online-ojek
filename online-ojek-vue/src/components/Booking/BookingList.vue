<template>
  <div class="list booking__list col-md-10">
     <h4> Booking List </h4>
      <div>
          <button class="btn btn-primary" @click="addBooking">Add New Booking</button>
      </div>
     <table class="table table-borderless table-hover">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Customer Name</th>
          <th scope="col">From</th>
          <th scope="col">To</th>
          <th scope="col">Driver Name</th>
          <th scope="col">Price</th>
          <th scope="col">Payment</th>
          <th scope="col">Status</th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="booking in bookings" :key="booking.id">
          <th scope="row">{{booking.id}}</th>
          <td>{{booking.customer.name}}</td>
          <td>{{booking.location_from}}</td>
          <td>{{booking.location_to}}</td>
          <td>{{booking.driver.name}}</td>
          <td>{{booking.price}}</td>
          <td>{{booking.payment.name}}</td>
          <td>{{booking.status.toLowerCase().charAt(0).toUpperCase()+booking.status.toLowerCase().slice(1)}}</td>
          <td v-if="booking.status === 'ACCEPTED'">
            <button class="btn btn-danger" @click="cancelBooking(booking.id)">Cancel</button>
          </td>
          <td v-if="booking.status === 'ACCEPTED'">
            <button class="btn btn-success" @click="completeBooking(booking.id)">Done</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
  name: 'bookingList',
  data(){
    return {
        bookings:[]
    };
  },
  mounted(){
    axios.get(`${API_URL}/bookings`).then(
      response => (this.bookings=response.data) 
      ).catch();
  },
  methods:{
    cancelBooking(id){
         axios.put(`${API_URL}/bookings/${id}/status/CANCELLED`, {
        }).then(this.$router.push({name:'bookings'}))
        .catch();
        this.$router.push({name:'bookings'});
        this.$router.go(0);
    },
    completeBooking(id){
         axios.put(`${API_URL}/bookings/${id}/status/DONE`, {
        }).then(this.$router.push({name:'bookings'}))
        .catch();
        this.$router.push({name:'bookings'});
        this.$router.go(0);
    },
    addBooking(){
      this.$router.push({name:'bookingsAdd'}); 
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
