<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
	$font-family:   "Roboto";
$font-size:     14px;

$color-primary: #ABA194;

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: $font-family;
    font-size: $font-size;
    background-size: 200% 100% !important;
    animation: move 10s ease infinite;
    transform: translate3d(0, 0, 0);
    background: linear-gradient(45deg, #49D49D 10%, #A2C7E5 90%);
    height: 100vh;
    display: flex;
    align-items: center;
}

.user {
    width: 90%;
    max-width: 340px;
    margin: 10vh auto;
}

.user__header {
    text-align: center;
    opacity: 0;
    transform: translate3d(0, 500px, 0);
    animation: arrive 500ms ease-in-out 0.7s forwards;
}

.user__title {
    font-size: $font-size;
    margin-bottom: -10px;
    font-weight: 500;
    color: white;
}

.form {
    margin-top: 40px;
    border-radius: 6px;
    overflow: hidden;
    opacity: 0;
    transform: translate3d(0, 500px, 0);
    animation: arrive 500ms ease-in-out 0.9s forwards;
}

.form--no {
    animation: NO 1s ease-in-out;
    opacity: 1;
    transform: translate3d(0, 0, 0);
}

.form__input {
    display: block;
    width: 100%;
    padding: 20px;
    font-family: $font-family;
    -webkit-appearance: none;
    border: 0;
    outline: 0;
    transition: 0.3s;
    
    &:focus {
        background: darken(#fff, 3%);
    }
}

.btn {
    display: block;
    width: 100%;
    padding: 20px;
    font-family: $font-family;
    -webkit-appearance: none;
    outline: 0;
    border: 0;
    color: #202020;
    background: $color-primary;
    transition: 0.3s;
    
    
}

.btn:hover {
	cursor: pointer;
}

@keyframes NO {
  from, to {
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
  }

  10%, 30%, 50%, 70%, 90% {
    -webkit-transform: translate3d(-10px, 0, 0);
    transform: translate3d(-10px, 0, 0);
  }

  20%, 40%, 60%, 80% {
    -webkit-transform: translate3d(10px, 0, 0);
    transform: translate3d(10px, 0, 0);
  }
}

@keyframes arrive {
    0% {
        opacity: 0;
        transform: translate3d(0, 50px, 0);
    }
    
    100% {
        opacity: 1;
        transform: translate3d(0, 0, 0);
    }
}

@keyframes move {
    0% {
        background-position: 0 0
    }

    50% {
        background-position: 100% 0
    }

    100% {
        background-position: 0 0
    }
}
</style>
</head>
<body>
<div class="user">
    <header class="user__header">
        <h1 class="user__title">Register</h1>
    </header>
    <form class="form" method="post" action="/Assignment1/Register">
    	<c:if test = "${Result.response != null }">
    	<div style="padding: 10px; display: flex; justify-content: center; font-size: 20px; color: #DD3A24; font-weight: 500;">${Result.response}</div>
    	</c:if>
        <div class="form__group">
            <input type="text" placeholder="Username" class="form__input" name="username" autocomplete="off" required />
        </div>
        <div class="form__group">
            <input type="text" placeholder="First name" class="form__input" name="firstname" autocomplete="off" required />
        </div>
        <div class="form__group">
            <input type="text" placeholder="Last name" class="form__input" name="lastname" autocomplete="off" required />
        </div>
        
        
        <div class="form__group">
            <input type="email" placeholder="Email" class="form__input" name="email" autocomplete="off" required />
        </div>
        
        <div class="form__group">
            <input type="password" placeholder="Password" class="form__input" name="password" autocomplete="off" required />
        </div>
        
        <button class="btn" type="submit">Register</button>
    </form>
</div>
</body>
</html>