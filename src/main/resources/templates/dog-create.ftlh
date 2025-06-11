<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Add New Dog Breed</title>
  <link rel="stylesheet" href="/css/styles.css" />
</head>
<body>
  <header>
    <h1>Add New Dog Breed</h1>
    <nav>
      <ul>
        <li><a href="/dogs">Breed List</a></li>
        <li><a href="/about">About</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <form action="/dogs/create" method="post">
      <label for="name">Breed Name:</label><br />
      <input type="text" id="name" name="name" required /><br /><br />

      <label for="otherNames">Other Names:</label><br />
      <input type="text" id="otherNames" name="otherNames" /><br /><br />

      <label for="origin">Origin:</label><br />
      <input type="text" id="origin" name="origin" required /><br /><br />

      <label for="imageURL">Image URL:</label><br />
      <input type="text" id="imageURL" name="imageURL" placeholder="images/French Bulldog.jpg" /><br /><br />

      <label for="description">Description:</label><br />
      <textarea id="description" name="description" rows="5" cols="40"></textarea><br /><br />

      <button type="submit">Add Breed</button>
    </form>
  </main>

  <script src="/js/main.js"></script>
</body>
</html>
