<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Add New Dog Breed</title>
  <link rel="stylesheet" href="css/styles.css" />
</head>
<body>
  <header>
    <h1>Add New Dog Breed</h1>
    <nav>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="dog-list.ftlh">Breed List</a></li>
        <li><a href="about.html">About</a></li>
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

      <label for="imagePath">Image URL (relative to images/):</label><br />
      <input type="text" id="imageURL" name="imageURL" placeholder="French Bulldog.jpg" /><br /><br />

      <label for="desc">Description:</label><br />
      <textarea id="desc" name="desc" rows="5" cols="40"></textarea><br /><br />

      <button type="submit">Add Breed</button>
    </form>
  </main>

  <script src="js/main.js"></script>
</body>
</html>
