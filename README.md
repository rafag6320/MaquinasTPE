EJEMPLO DE ARBOL DE EXPLORACION BACKTRACKING

PiezasAImpletementar = 4

[]
├── [M1]
│   └── [M1, M1] → suma = 6 (descartado)
│   └── [M1, M2] → suma = 5 (descartado)
│   └── [M1, M3] → suma = 4 ✅ 
├── [M2]
│   └── [M2, M1] → suma = 5
│   └── [M2, M2] → suma = 4 ✅
│   └── ...
├── [M3]
│   └── [M3, M3, M3, M3] → suma = 4 ✅
