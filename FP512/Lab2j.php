<?php

	//set up some string variables
	$a = 'the';
	$b = 'games';
	$c = 'begin';
	$d = 'now';
	
	//combine them using the concatenation operator
	//this return 'the games begin now'
	
	$statement = $a.' '.$b.' '.$c.' '.$d.'<br>';
	print $statement;
	
	// and this return 'begin the games now!'
	$command = $c.' '.$a.' '.$b.' '.$d.'!';
	print $command;
?>
