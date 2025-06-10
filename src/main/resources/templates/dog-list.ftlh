<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dog Breeds</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <header>
    <h1>Index</h1>
    <nav>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="details.html">Details</a></li>
        <li><a href="about.html">About</a></li>
      </ul>
    </nav>
  </header>
  <main>
    <section class="gallery">
      <#list dogList as dog>
        <article>
          <img src="${dog.imageURL!'Insert here'}" alt="${dog.name!'Insert here'}">
          <h2>${dog.name!'Insert here'}</h2>
          <p>
            <b>Other names:</b> ${dog.otherNames}<br />
            <b>Origin:</b> ${dog.origin}
          </p>
          <a href="details.html?name=${dog.name?url}">Read more</a>
        </article>
      </#list>
    </section>
  </main>
  <script src="js/main.js"></script>
</body>
</html>
