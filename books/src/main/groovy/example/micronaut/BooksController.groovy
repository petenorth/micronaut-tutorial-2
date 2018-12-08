package example.micronaut

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured

@CompileStatic
@Controller("/api")
@Secured("isAuthenticated()")
class BooksController {

    private final BooksRepository booksRepository

    BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository
    }

    @Get("/books")
    List<Book> list() {
        booksRepository.findAll()
    }
}
