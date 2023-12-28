# Karak

## Coding Conventions

### Annotations

Every object variable/attribute/parameter is implicitly `@NotNull`
unless explicitly stated `@Nullable`.

### Naming tests

> MethodName_StateUnderTest_ExpectedBehavior

- **example:**
  - *isAdult_AgeLessThan18_False*
- **cons:**
  - long method names
  - should be renamed if tested method change name
