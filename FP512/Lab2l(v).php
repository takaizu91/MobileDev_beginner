<?php

	for ($x = 10; $x <= 100; $x++)
	{
		if (($x % 12) == 0)
		{
			echo "$x ";
			echo "<br />";
		}
		else
		{
			continue;
		}
	}
?>
