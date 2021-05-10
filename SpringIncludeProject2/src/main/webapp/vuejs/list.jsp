<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
}
h3{
  text-align: center;
}
</style>
</head>
<body>
  <div style="height: 30px"></div>
  <div class="container" id="app">
    <div class="row">
      <div class="text-center">
         <input type="button" class="btn btn-lg btn-success" value="냉동/가공식품" v-on:click="shopChange(45)">
	     <input type="button" class="btn btn-lg btn-info" value="건강식품" v-on:click="shopChange(59)">
	     <input type="button" class="btn btn-lg btn-warning" value="기타식품" v-on:click="shopChange(83)">
	     <input type="button" class="btn btn-lg btn-danger" value="소스류" v-on:click="shopChange(60)">
      </div>
      <div style="height: 20px"></div>
      <div class="row">
        <div class="col-md-4" v-for="s in shop">
	     <div class="thumbnail">
	      <a href="#">
	        <img :src="s.poster" style="width:260px;height: 250px">
	        <div class="caption">
	          <p>{{s.title}}</p>
	          <p class="text-right">{{s.price}}</p>
	        </div>
	      </a>
	    </div>
	  </div>
      </div>
    </div>
  </div>
  <script>
  let app=new Vue({
	  el:'#app',
	  data:{
		  shop:[],
		  cno:45,
		  page:1
	  },
	  beforeCreate(){
		  console.log("beforeCreate() Call..");
	  },
	  created(){
		  console.log("created() Call..");
	  },
	  beforeMount(){
		  console.log("beforeMount() Call..");
	  },
	  beforeUpdate(){
		  console.log("beforeUpdate() Call..");
	  },
	  updated(){
		  console.log("updated() Call..");
	  },
	  beforeDestory(){
		  console.log("beforeDestory Call..");
	  },
	  destoryed(){
		  console.log("destoryed Call..");
	  },
	  methods:{
		  shopChange(cno){
			  axios.get('http://localhost/web/vuejs/shop_list.do',{
				  params:{
					  cno:cno,
					  page:this.page
				  }
			  }).then(response=>{
				  this.shop=response.data;
			  })
		  }
	  },
	  mounted(){
		  axios.get('http://localhost/web/vuejs/shop_list.do',{
			  params:{
				  cno:this.cno,
				  page:this.page
			  }
		  }).then(response=>{
			  this.shop=response.data;
		  })
	  }
  })
  </script>
</body>
</html>
  







