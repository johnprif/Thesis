# Thesis: Smallest Enclosing Circle & Voronoi Diagram

> Implementation of an O(n log n) algorithm for the Smallest Enclosing Circle and the Voronoi Diagram, using efficient structures (Red‑Black tree, HashMap) with a JavaFX GUI.

> Sven Skyum, “Implementation of an Algorithm for the Calculation of the Smallest Enclosing Circle and the Voronoi Diagram,” 1991.

[Download Latest Release (Windows executable)](https://github.com/johnprif/Thesis/releases/latest)
## 📋 Table of Contents

1. [Overview](#overview)  
2. [Features](#features)  
3. [Screenshots](#screenshots)  
4. [Technologies](#technologies)  
5. [Installation](#installation)  
6. [Usage](#usage)  
7. [Architecture](#architecture)  
8. [Contributing](#contributing)  
9. [License](#license)  
10. [Contact](#contact)  

## Overview

This project implements Sven Skyum’s 1991 algorithm for computing the **Smallest Enclosing Circle** and the **Voronoi Diagram** in **O(n log n)** time, using Java 17, JavaFX, and classic data structures (Red‑Black BST, HashMap). It follows MVC and Singleton patterns to deliver a user‑friendly GUI on Windows.

## Features

- **Efficient O(n log n) algorithm** for smallest enclosing circle (Welzl/Skyum).  
- **Voronoi diagram** construction via divide‑and‑conquer and balanced trees.  
- **JavaFX GUI**: Interactive visualization, zoom/pan, and export functionality.  
- **MVC architecture** for clean separation of model, view, and controller.  
- **Multiple input formats**: CSV, Excel via Apache POI, and manual point entry.  

## Screenshots

<p align="center">  
  <img src="https://github.com/johnprif/Thesis/assets/56134761/9745fa47-aef0-4f40-932c-284ca11623d3" alt="Enclosing Circle View (EN)" width="300"/>  
  <img src="https://github.com/johnprif/Thesis/assets/56134761/30259e62-f042-4a29-af1d-c07d94569564" alt="Enclosing Circle View (GR)" width="300"/> 
  <img src="https://github.com/johnprif/Thesis/assets/56134761/fbeacc07-81e3-4036-b431-3d5e503532e2" alt="Enclosing Circle Info (EN)" width="300"/>
  <img src="https://github.com/johnprif/Thesis/assets/56134761/8ac7f756-f24e-4f2d-a3f8-2e7d36967b9d" alt="Enclosing Circle Info (GR)" width="300"/>
  <img src="https://user-images.githubusercontent.com/56134761/221437223-550a3a34-e13a-4e4e-a43e-22b36880b486.png" alt="Voronoi Diagram (Smallest Enclosing Circle)" width="300"/>  
  <img src="https://user-images.githubusercontent.com/56134761/221437265-6b697043-8404-46b6-b332-1f937c332d25.png" alt="Voronoi Diagram (Nearest Neighbor Voronoi Diagram)" width="300"/> 
  <img src="https://user-images.githubusercontent.com/56134761/221437301-65a3ae36-84b1-47b8-afb0-22edd18d1bb9.png" alt="Voronoi Diagram (Farthest Neighbor Voronoi Diagram)" width="300"/> 
</p>

## Technologies

| Layer         | Technology                                    |
|---------------|-----------------------------------------------|
| Language      | Java 17                                        |
| GUI           | JavaFX 19                                      |
| Data Parsing  | OpenCSV 5.7.1, Apache POI 5.2.3                |
| Algorithms    | Custom Red‑Black BST, HashMap, divide‑and‑conquer |
| Patterns      | MVC, Singleton                                 |

## Installation

**Clone repository**  
   ```bash
   git clone https://github.com/johnprif/Thesis.git
   cd Thesis
```

## Usage
1. **Load points**: Load -> Open CSV/Excel or manual input.
2. **Visualize**: Pan/zoom the JavaFX canvas; use export buttons for PNG.

## Architecture
```plaitext
+----------------+      +-----------------+      +------------------+
| JavaFX GUI     | <--> | Controller      | <--> | Algorithm Module |
+----------------+      +-----------------+      +------------------+
                                 |
                                 v
                       +----------------------+
                       | Data Parser (CSV/Excel) |
                       +----------------------+
```
- **MVC** separates presentation (JavaFX), control flow (Controller), and computation (Algorithm).
- **Algorithm Module** implements circle/Voronoi logic with Red-Black BST and HashMap.

## Contributing
Contributes  welcome! Please:

1. Fork the repo.
2. Create a feature branch: `git checkout -b feature/YourFeature`.
3. Commit: `git commit -m "Add YourFeature"`.
4. Push: `git push origin feature/YourFeature`.
5. Open a Pull Request.

## License
This project is licensed under the **MIT License**, See [LICENSE](https://github.com/johnprif/Thesis/blob/main/LICENSE) for details.

## Contact
- GitHub: [joanisprifti](https://github.com/joanisprifti)
- Email: [joanisprifti@gmail.com](mailto:joanisprifti@gmail.com)
- Phone: [+306940020178](tel:+306940020178)


