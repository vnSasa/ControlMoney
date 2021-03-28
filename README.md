# Personal expenses management application that allows users to track how much money have they spent.

As a result of test problem solution you should provide a web server application that has following API:

● POST <host>/expenses — adds expense entry to the list of user expenses. Expenses for various dates could be added in any order. Endpoint accepts JSON with the following data:
  date — is the date when expense occurred
  amount — is an amount of money spent
  currency — the currency in which expense occurred
  product — is the name of product purchased

● GET <host>/expenses — shows the list of all expenses grouped and sorted by date

● DELETE <host>/expenses?date=2021-04-25 — removes all expenses for specified date, where:
  date — is the date for which all expenses should be removed

● GET <host>/total?base=PLN — this command should take a list of exchange rates from https://api.exchangerate.host/convert converter calculate the total amount of money spent and present it to user in specified currency, where:
  base — is the currency in which total amount of expenses should be presented
