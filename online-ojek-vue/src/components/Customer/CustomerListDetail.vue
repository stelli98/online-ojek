<template>
    <div class="col-md-10">
        <h4>Customer Details</h4>
        <div v-if="customer">
            <h6>ID</h6>
            <p>{{customer.id}}</p>
            <h6>Name</h6>
            <p>{{customer.name}}</p>
            <h6>Balance</h6>
            <p>{{customer.balance}}</p>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
    name:'customerListDetail',
    data(){
        return {
            customer:null
        }
    },
    mounted(){
        axios.get(`${API_URL}/customers/${this.$route.params.id}`).then(
        response => (this.customer=response.data) 
        ).catch(e=>{
         this.error.push(e);
        })
    }
}
</script>

<style scoped>
div{
    margin:20px auto;
}

h6{
    font-weight: 600;
}
</style>
