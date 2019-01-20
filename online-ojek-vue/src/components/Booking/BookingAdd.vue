<template>
    <div class="col-md-6">
        <h4>Book A Ride</h4>
        <form>
            <div class="form-group">
              <label for="cust-id">Customer Id</label>
              <input type="number" v-model="custId" class="form-control" id="cust-id" placeholder="Enter customer id">
              <!-- <select class="form-control" v:model="custId">
                <option disabled value="">Please select one</option>
                <option v-for="customer in customers" :key="customer.id" :value="customer.id">{{customer.name}}</option>
              </select> -->
            </div>
            <div class="form-group">
              <label for="driver-id">Driver Id</label>
              <input type="number" v-model="driverId" class="form-control" id="driver-id" placeholder="Enter driver id">
              <!-- <select class="form-control" v-if="drivers">
                <option v-for="driver in drivers" :key="driver.id" :value="driver.id">{{driver.name}}</option>
              </select> -->
            </div>
            <div class="form-group">
              <label for="from">From</label>
              <input type="text" v-model="from" class="form-control" id="from" placeholder="Enter origin address">
            </div>
            <div class="form-group">
              <label for="to">To</label>
              <input type="text" v-model="to" class="form-control" id="to" placeholder="Enter destination address">
            </div>
            <div class="form-group">
              <label for="payment">Payment ID</label>
              <input type="int" v-model="payment" class="form-control" id="payment" placeholder="Enter payment id">
              <!-- <select class="form-control" v-if="paymentMethods">
                <option v-for="paymentMethod in paymentMethods" :key="paymentMethod.id" :value="paymentMethod.id">{{paymentMethod.name}}</option>
              </select> -->
            </div>
            <button type="button" class="btn btn-primary" @click="createBooking">Submit</button>
        </form>        
    </div>    
</template>
<script>
import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
    name:'bookingAdd',
    data(){
        return{
            custId:'',
            driverId:"",
            from:"",
            to:"",
            payment:"",
            paymentMethods:[],
            customers:[],
            drivers:[]
        };
    },
    mounted(){
        axios.get(`${API_URL}/customers/status/eligible`).then(
        response => (this.customers=response.data)).catch(),
        
        axios.get(`${API_URL}/drivers/status/eligible`).then(
        response => (this.drivers=response.data)).catch(),
    
        axios.get(`${API_URL}/payment-method`).then(
        response => (this.paymentMethods=response.data)).catch()
    
    },
    methods:{
        createBooking(){
         axios.post(`${API_URL}/bookings`, {
                customer:{
                    id: this.custId
                },
                driver:{
                    id:this.driverId
                },
                location_to:this.to,
                location_from:this.from,
                payment:{
                    id:this.payment
                }
        }).then()
        .catch();
        
      this.$router.push({name:'bookings'});
      this.$router.go(0);
    }
}
}
</script>
<style scoped>
div{
    margin:25px auto;
}

</style>
