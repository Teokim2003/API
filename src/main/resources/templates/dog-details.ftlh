<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>${dog.name!'Insert here'}</title>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
  <header>
    <h1>${dog.name!'Insert here'}</h1>
    <nav>
      <ul>
        <li><a href="/dogs">Home</a></li>
        <li><a href="/about">About</a></li>
      </ul>
    </nav>
  </header>
  <main>
    <img src="${dog.imageURL!'Insert here'}" alt="${dog.name!'Insert here'}">
    <h2>Details</h2>
    <p>
      ${dog.desc!'Insert here'}
      <br /><br />
      <b>Other names:</b> ${dog.otherNames!'Insert here'}<br />
      <b>Origin:</b> ${dog.origin!'Insert here'}
    </p>
    <a href="/dogs/updateForm/${dog.id}">Edit</a> |
    <a href="/dogs/delete/${dog.id}" onclick="return confirm('Are you sure?')">Delete</a>
  </main>
  <script src="/js/main.js"></script>
</body>
</html>
