# html-diff

Show a visual diff of two HTML files by comparing their [Hiccup representations](https://github.com/weavejester/hiccup#syntax)

## Usage

`lein run -- http://google.com/ http://google.fr/`

Also works with local paths.

## Picture

![screenshot](screenshot.png)

## Todo

- Exit after launching the diff program
- Fix `cat already refers to: #'clojure.core/cat` warning
