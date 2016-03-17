<?php
session_start();
if(!isset($_SESSION['username'])) {
  if($_POST['login']) {
    $con = mysqli_connect("localhost","root","sjirda96","userbase");

    $username = strip_tags($_POST['username']);
    $password = strip_tags($_POST['password']);

    $username = stripslashes($username);
    $password = stripslashes($password);

    $username = mysqli_real_escape_string($con, $username);
    $username = mysqli_real_escape_string($con, $username);
    $password = md5($password);
  
    $sql = "SELECT * FROM users WHERE username = '$username' LIMIT 1";
    $query = mysqli_query($con, $sql);
    $row = mysqli_fetch_array($query);

    $id = $row['id'];
    $db_password = $row['password'];

   if($password == $db_password) {
     $_SESSION['username'] = $username;
     $_SESSION['id'] = $id;
     $ipaddr = $_SERVER['REMOTE_ADDR'];
     $q = mysqli_query($con, "UPDATE users SET lastIp = '$ipaddr' WHERE username = '$username'");
     mysqli_execute($q);
     header("Location: index.php");

   } else {
     $incorrectDetails = true;
    }

  }
} else {
  header("Location: index.php");
}

?>

<html >
  <head>
    <meta charset="UTF-8">
    <title>DireQt Designs - Login page</title>
    
    
    
    
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" href="favicon.ico">
    
    
    
  </head>

  <body>

    <div class="login">
  <div class="login-triangle"></div>
  
  <?php if($incorrectDetails) {
    $incorrectDetails = false; ?>
  <h2 class="login-header">Incorrect Details!</h2>
  <?php } else { ?>
  <h2 class="login-header">Log in</h2>

  <?php
   } 
   ?>
  <form class="login-container" method="post">
    <p><input type="text" name="username" placeholder="Username"></p>
    <p><input type="password" name="password" placeholder="Password"></p>
    <p><input type="submit" name="login" value="Log in"></p>
  </form>
</div>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    
    
    
    
  </body>
</html>
