# Sass (Syntactically Awesome Style Sheets)

Sass (short for syntactically awesome style sheets) is a preprocessor scripting language that is interpreted or compiled into Cascading Style Sheets (CSS). SassScript is the scripting language itself.

Sass consists of two syntaxes. The original syntax, called "the indented syntax," uses a syntax similar to Haml.It uses indentation to separate code blocks and newline characters to separate rules. The newer syntax, SCSS (Sassy CSS), uses block formatting like that of CSS. It uses braces to denote code blocks and semicolons to separate rules within a block. The indented syntax and SCSS files are traditionally given the extensions .sass and .scss, respectively.

CSS3 consists of a series of selectors and pseudo-selectors that group rules that apply to them. Sass (in the larger context of both syntaxes) extends CSS by providing several mechanisms available in more traditional programming languages, particularly object-oriented languages, but that are not available to CSS3 itself. When SassScript is interpreted, it creates blocks of CSS rules for various selectors as defined by the Sass file. The Sass interpreter translates SassScript into CSS. Alternatively, Sass can monitor the .sass or .scss file and translate it to an output .css file whenever the .sass or .scss file is saved.

The indented syntax is a metalanguage. SCSS is a nested metalanguage and a superset of CSS, as valid CSS is valid SCSS with the same semantics.

SassScript provides the following mechanisms: variables, nesting, mixins, and selector inheritance.

## Key features

- Variables: Sass allows you to define variables that can store values, such as colors, font sizes, or any other CSS property. This makes it easy to reuse values throughout your stylesheets and update them in a centralized manner.

- Nested Rules: Sass allows you to nest CSS rules inside one another, which can help in organizing your styles and making the structure more readable.

- Mixins: Mixins are reusable pieces of CSS that can be included in other styles. This allows you to define common patterns or sets of properties and reuse them throughout your stylesheets.

- Partials: Sass supports partials, which are separate Sass files that can be imported into other Sass files. This modular approach helps in organizing styles across multiple files.

-Functions and Control Directives: Sass supports functions and control directives like @if, @for, and @each, allowing you to create more dynamic and flexible stylesheets.

## File extensions

Sass files use the .scss or .sass file extension, and they need to be compiled into regular CSS before being used on the web.
