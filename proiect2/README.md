# Santa Simulator
### Ion Dragos - Cosmin 

## DESIGN PATTERNS

### Builder -> pachet database -> Clasa child
    Am folosit acest design pattern pentru a instantia un copil doar cu
    detaliile pe care le primeste din input, iar pe urma sa adaugam ce
    mai este nevoie de-a lungul programului si pentru output. Ne ajuta acest
    lucru deoarece nu trebuie sa facem mai multi constructori pentru diferite
    cazuri.

## STRUCTURA PROGRAMULUI SI ORGANIZAREA ACESTUIA:

* simulation -> Simulation, SimulationUpdates:
  * Simulation:
    * am adaugat in flow-ul programului si niceScoreBonus-ul
    
  * SimulationUpdates:
    * am modularizat mai mult codul fata de etapa 1 si am modificat functiile 
    deja existente cu noile informatii pe care le primim
    * metodele shareGifts() si getSmallestPrice() acum tin cont si de cantitatea
    cadoului
    * metoda applyElf() vede ce elf are fiecare copil si ii modifica
    bugetul in functie de asta
    * metoda chooseMethodSharingGifts() sorteaza copiii in functie de
    cum ne este specificat in fiecare an pentru a imparti corespunzator
    cadourile
    * metoda shareGiftsYellowElf() imparte cadouri copiilor care nu au primit
    nimic in acel an din diferite motive, folosindu-se de metoda
    getSmallestPriceYellow()