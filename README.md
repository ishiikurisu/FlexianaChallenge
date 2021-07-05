# Flexina Challenge

## Installation and Usage

Be sure you have [Leiningen]() installed on your machine.

Clone the repository from Github:

``` sh
git clone https://github.com/ishiikurisu/FlexinaChallenge
cd FlexinaChallenge
```

To start the project, run:

``` sh
lein run
```

It should be available at http://localhost:3000. This command will do the
following:

- Install the required dependencies for the project
- Build the Clojurescript code
- Start the server

While developing, it's a good idea to keep the unit tests up to date.
To run them, execute:

``` sh
lein test
```

## API Description

### `GET /api/scramble`

#### Request

Accepted parameters:

- `str1`: the source string for scrambling
- `str2`: the target string

Every other parameter is going to be ignored.

Example requests:

```
http://localhost:3000/api/scramble?str1=joe&str2=eo
http://localhost:3000/api/scramble?str1=rekqodlw&str2=world
http://localhost:3000/api/scramble?str1=cedewaraaossoqqyt&str2=codewars
http://localhost:3000/api/scramble?str1=katas&str2=steak
```

#### Response

If the request is valid, it should 200 status code and a string representation
of either `true` or `false`.

## License

Copyright © 2021 www.crisjr.eng.br

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
