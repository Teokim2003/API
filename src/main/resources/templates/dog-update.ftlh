<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Update Dog Breed - ${dog.name}</title>
  <link rel="stylesheet" href="css/styles.css" />
</head>
<body>
  <header>
    <h1>Update Dog Breed: ${dog.name}</h1>
    <nav>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="dog-list.ftlh">Breed List</a></li>
        <li><a href="about.html">About</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <form action="/dogs/update" method="post">
      <!-- Hidden input for identifying the dog, e.g. by id or original name -->
      <input type="hidden" name="id" value="${dog.id}" />

      <label for="name">Breed Name:</label><br />
      <input type="text" id="name" name="name" value="${dog.name}" required /><br /><br />

      <label for="otherNames">Other Names:</label><br />
      <input type="text" id="otherNames" name="otherNames" value="${dog.otherNames}" /><br /><br />

      <label for="origin">Origin:</label><br />
      <input type="text" id="origin" name="origin" value="${dog.origin}" required /><br /><br />

      <label for="imageURL">Image URL (relative to images/):</label><br />
      <input type="text" id="imageURL" name="imageURL" value="${dog.imageURL!'Insert here'}" /><br /><br />

      <label for="desc">Description:</label><br />
      <textarea id="desc" name="desc" rows="5" cols="40">${dog.desc}</textarea><br /><br />

      <button type="submit">Update Breed</button>
    </form>
  </main>

  <script src="js/main.js"></script>
</body>
</html>
