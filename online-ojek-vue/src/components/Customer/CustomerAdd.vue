<template>
    <div class="col-md-6">
        <h4>Add New Customer</h4>
        <form>
            <div class="form-group">
              <label for="name">Name</label>
              <input type="text" v-model="name" class="form-control" id="name" placeholder="Enter name">
            </div>
            <div class="form-group">
              <label for="balance">Balance</label>
              <input type="number" v-model="balance" class="form-control" id="balance" placeholder="Enter Balance">
            </div>
            <button type="button" class="btn btn-primary" @click="createCustomer">Submit</button>
        </form>        
    </div>    
</template>
<script>
import axios from 'axios';
const API_URL='http://localhost:8080/api';

export default {
    name:'CustomerAdd',
    data(){
        return{
            name:"",
            balance:""
        };
    },
    methods:{
        createCustomer(){
         axios.post(`${API_URL}/customers`, {
                name:this.name,
                balance:this.balance
        }).then()
        .catch((e) => {
            console.error(e)
        });
        
        this.$router.push({name:'customers'});
    }  
  }
}

</script>
<style scoped>
div{
    margin:25px auto;
}

</style>
