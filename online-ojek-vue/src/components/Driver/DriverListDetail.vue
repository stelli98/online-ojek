<template>
    <div class="col-md-10">
        <h4>Driver Details</h4>
        <div v-if="driver">
            <h6>ID</h6>
            <p>{{driver.id}}</p>
            <h6>Name</h6>
            <p>{{driver.name}}</p>
            <h6>Balance</h6>
            <p>{{driver.balance}}</p>
            <h6>Status</h6>
            <p>{{showStatus}}</p>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
    name:'DriverListDetail',
    data(){
        return {
            driver:null
        }
    },
    computed:{
        showStatus(){
            status=this.driver.status.toLowerCase();
            return status.charAt(0).toUpperCase()+status.slice(1);
        }
    },
    mounted(){
        axios.get(`${API_URL}/drivers/${this.$route.params.id}`).then(
        response => (this.driver=response.data) 
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
