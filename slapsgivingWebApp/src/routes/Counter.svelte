<script>
	import { spring } from 'svelte/motion';
  import { onMount } from 'svelte';


	let days = 0;
	let hours = 0;
	let minutes = 0;
	let seconds = 0;


  const getThanksGivingDate = () => {
    const now = new Date();
    const year = now.getFullYear()
    // set the date to November 1st 
    const thanksgiving = new Date(year, 10, 1)
    thanksgiving.setDate(thanksgiving.getDate() + ((11 - thanksgiving.getDay()) % 7) + 21)
    // shit goes down at 9 pm
    thanksgiving.setHours(21,0,0,0);
    if ( now > thanksgiving ) {
      thanksgiving.setFullYear(year + 1);
      thanksgiving.setDate(thanksgiving.getDate() + (( 11 - thanksgiving.getDay()) % 7 ) + 21)
    }
    return thanksgiving;
  }

  const updateCountdown = () => {
    const now = new Date();
    const thanksgiving = getThanksGivingDate();
    const timeDifference = thanksgiving - now;

    days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
    hours = Math.floor((timeDifference / (1000 * 60 * 60)) % 24)
    minutes = Math.floor((timeDifference / 1000 / 60) % 60 );
    seconds = Math.floor((timeDifference / 1000) % 60);
  }

  // modern day useEffect
  onMount(() => { 
    // runs immediately this page is mounted on the DOM 
    updateCountdown();
    // updates every second 
    const interval = setInterval(updateCountdown, 1000);

    return () => clearInterval(interval);
  })
</script>

<div class="countdown">
			<strong>{days}</strong>:
			<strong>{hours}</strong>:
			<strong>{minutes}</strong>:
			<strong>{seconds}</strong>
</div>

<style>
 
strong {
  color: red;
  font-weight: bold; /* corrected from 'font: extrabold' */
  margin-inline: 12px;
}

.countdown {
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: Arial, sans-serif;
  text-align: center;
  padding: 20px;
  box-sizing: border-box;
}

/* Base font size for larger screens */
.countdown strong {
  font-size: 4em;
}

/* Adjust font size for smaller screens */
@media (max-width: 1200px) {
  .countdown strong {
    font-size: 3em;
  }
}

@media (max-width: 992px) {
  .countdown strong {
    font-size: 2.5em;
  }
}

@media (max-width: 768px) {
  .countdown strong {
    font-size: 2em;
  }
}

@media (max-width: 576px) {
  .countdown strong {
    font-size: 1.5em;
  }
}
</style>
