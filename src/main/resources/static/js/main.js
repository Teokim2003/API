// Show welcome message on index page
document.addEventListener("DOMContentLoaded", function () {
  if (window.location.pathname.includes("index.html") || window.location.pathname === "/") {
    console.log("Welcome to the Animal Gallery!");
  }
});

// Back to top button
const topButton = document.createElement("button");
topButton.textContent = "↑ Top";
topButton.style.position = "fixed";
topButton.style.bottom = "20px";
topButton.style.right = "20px";
topButton.style.padding = "10px";
topButton.style.display = "none";
topButton.style.backgroundColor = "#2d3e50";
topButton.style.color = "white";
topButton.style.border = "none";
topButton.style.borderRadius = "5px";
topButton.style.cursor = "pointer";
document.body.appendChild(topButton);

window.addEventListener("scroll", () => {
  topButton.style.display = window.scrollY > 100 ? "block" : "none";
});

topButton.addEventListener("click", () => {
  window.scrollTo({ top: 0, behavior: "smooth" });
});