<?php

	//define number and limits for multiplication tables
	$num = 11;
	$upperLimit = 10;
	$lowerLimit = 1;
	
	//loop and multiply to create table
	do
	{
		echo "$num x $lowerLimit = " . ($num * $lowerLimit);
		echo "<br />";
		$lowerLimit++;
	} while ($lowerLimit <= $upperLimit);
?>
