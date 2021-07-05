# Flexiana Challenge

This challenge consisted of 3 tasks:

1. Implement a `scrambles?` function that verifies if one string can be
   rearranged to form other.
2. Create an endpoint that calls this function.
3. Create a front-end for this endpoint using Clojurescript.

After the completion of the challenge, the repository is organized as such:

- `src/challenge/lib.clj` contains an implementation of the `scrambles?`
  function.
    - To complete the challenge, the chosen algorithm was to count how many
      of each letter a word contains and check if there are enough letters
      to form the other one by scrambling.
    - Accompanying unit tests are included on `test/challenge/core_test.clj`
- `src/challenge/core.clj` contains the routing calls.
    - It uses HTTPKit, Compojure, and Ring to implement simple endpoints.
    - Templating is done with Selmer. It should be noted the templates are
      in the `resources` folder.
- `src/cljs/app.cljs` contains all front-end code, including handlers to deal
  with button click events, input validation, and API calls. 
