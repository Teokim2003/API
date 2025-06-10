<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>${dogName!'Insert here'}</title>
  <title>French Bulldog</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <header>
    <h1>${dogName!'Insert here'}</h1>
    <nav>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="details.html">Details</a></li>
        <li><a href="about.html">About</a></li>
      </ul>
    </nav>
  </header>
  <main>
    <img src="${imageURL!'Insert here'}" alt="${dogName|'Insert here'}">
    <h2>Details</h2>
    <p>
      ${desc!'Insert here'}
      <br /><br />
      <b>Other names:</b> ${otherNames!'Insert here'}<br />
      <b>Origin:</b> ${origin!'Insert here'}
    </p>
  </main>
  <script src="js/main.js"></script>
</body>
</html>
