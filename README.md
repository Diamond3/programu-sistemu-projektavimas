# programu-sistemu-projektavimas
Deimantas Eidukevičius, 2 grupė

----
<h2>Lab 3</h2>

  - Validatoriai veikia gerai, buvo gerai padaryti ir suprantami.
  - Vienintelis netikslumas kurį pavyko pastebeti, kad EmailValidator išmeta OutOfBoundsException kuomet yra paduodamas paštas be domain dalies.

Validatorių bibliotekos panaudojimą galima rasti: **LibraryUsage** branch [/app-web/](app-web/)

----
<h2>Lab 2</h2>

  - Unit testai buvo suprantami ir aiškiai pateikti. Testai buvo be klaidų ir jų užteko patikrinti kuriamus validatorius.
  - Slaptažodžio tikrinimo testai kreipdamiesi į validavimo funkciją nenurodo slaptažodžio ilgio, tad jeigu numatytasis slaptažodžio ilgis pasikeistų šie testai būtų netikslūs. Kad tokios problemos nekiltų, manau reikėtų užtikrinti, kad slaptažodžio tikrinimo funkcija taip pat gauna ir numatytąjį slaptažodžio ilgį.

Validatorių implementaciją galima rasti: **main** branch [/src/com/alemal/validation/](src/com/alemal/validation/)
