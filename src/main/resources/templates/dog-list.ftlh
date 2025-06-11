<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dog Breeds</title>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
  <header>
    <h1>All Dogs</h1>
    <nav>
      <ul>
        <li><a href="/dogs/createForm">Add Dog</a></li>
        <li><a href="/about">About</a></li>
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
            <b>Other names:</b> ${dog.otherNames!'Insert here'}<br />
            <b>Origin:</b> ${dog.origin!'Insert here'}
          </p>
          <a href="/dogs/${dog.id}">Read more</a>
        </article>
      </#list>
    </section>
  </main>
  <script src="/js/main.js"></script>
</body>
</html>
