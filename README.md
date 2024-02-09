# Karak

## Architecture

So far architecture is documented on *Miro.com* using a board with diagrams.
For read-only view click [here](https://miro.com/app/board/uXjVNC-RX4Y=/?share_link_id=647445331921).

> **TODO: move architecture documentation to GitHub pages (?)**

## Coding Conventions

### Annotations

Every object variable/attribute/parameter is implicitly `@NotNull`
unless explicitly stated `@Nullable`.
However, `@NotNull` annotation should be used to prevent confusion and warnings.

### Naming tests

> MethodName_StateUnderTest_ExpectedBehavior

- **example:**
  - *isAdult_AgeLessThan18_False*
- **cons:**
  - long method names
  - should be renamed if tested method change name
