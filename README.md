# html-diff

Show a visual diff of two HTML files by comparing their [Hiccup representations](https://github.com/weavejester/hiccup#syntax)

## Installation

Install Inlein: http://inlein.org/#install

## Usage

`./html-diff http://www.google.com/ http://www.google.fr/`

Also works with local files:

`./html-diff ./1.html ./2.html`

## Picture

![screenshot](screenshot.png)

## Todo

- Exit after launching the diff program
- Fix `cat already refers to: #'clojure.core/cat` warning