# Problem
This is a table test for *DPK14 - 2D Walk*:

**Create a function that can move a fighter in a 2D grid. The grid should be a 2D array.**
```
grid = [
  ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
  ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
]
```

**The moves should be:**
- **"up"**
- **"down"**
- **"left"**
- **"right"**

**The function should receive the grid, the initial position of the fighter and a list of moves.**
```
move(grid, [0,0], ["up", "left", "down", "right"])
```

**Every time a player move to a new position, the old position should be empty.**
```
move(grid, [0,0], ["up"]) -> 
      ["", "E.Honda", "Blanka", "Guile", "Balrog", "Vega", 
      "Ryu", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
```

**What the function needs to return is a list with the name of all players was beaten, therefore removed from the grid.**
```
move(grid, [0,0], ["up", "left", "down", "right"]) -> ["ken", "M.Bison", "Vega"] 
```

## Table Test - Implementation 1
