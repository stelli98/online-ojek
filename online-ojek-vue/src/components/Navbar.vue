<template>
<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <img src="../assets/motorbiking.png" width="30" height="30" class="d-inline-block align-top" alt="">
            Online Ojek 
        </a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <router-link to="/customers" class="nav-link">Customers</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/drivers" class="nav-link">Drivers</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/bookings" class="nav-link">Bookings</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/payment-method" class="nav-link">Payment Methods</router-link>  
              </li>
            </ul>
        </div>        
    </nav>
</div>
</template>

<script>

export default {
  name: 'Navbar'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
