<%@ page pageEncoding="utf-8"%>

<style>
	.container{
   		width: 50%;
   		margin: 100px 300px;
   		text-align: center;
	}
	.box{
        border-radius: 10px;
        box-shadow: 0px 0px 5px gray;
        padding: 10px;
        margin: 5px;
        background: pink;
     }
</style>

<div class="container">
		<div class="box">
			<h3>User Edition</h3>
			<form action="/Lab4/user.php" method="post">
				Username:
				<input name="username" value="${form.username}" /><br>
				Password:
				<input name="password" value="${form.password}" /><br>
				<input name="remember" type="checkbox" checked="${form.remember}" />
				Remember me?
				<br>
				<button>Create</button>
			</form>
		</div>
	</div>
