<script>
	import Counter from './Counter.svelte';
</script>

<svelte:head>
	<title>Slapsgiving</title>
	<meta name="description" content="Countdown to slapmania" />
</svelte:head>

<section>
	<h1>
		SLAP SCHEDULED:
	</h1>

	<Counter />
</section>

<style>
	section {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		flex: 0.6;
	}

	h1 {
    width: 100%;
    color: red;
	}

</style>
