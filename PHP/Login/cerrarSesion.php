<?php
session_name('NOMBRE_SESION');
session_start();
session_destroy();
header('Location:login.php');