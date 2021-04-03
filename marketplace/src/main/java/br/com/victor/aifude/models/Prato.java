package br.com.victor.aifude.models;

import br.com.victor.aifude.dtos.PratoDTO;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;

import java.math.BigDecimal;
import java.util.stream.StreamSupport;

public class Prato {
    public Long id;
    public String nome;
    public String descricao;
    public Restaurante restaurante;
    public BigDecimal preco;

    public static Multi<PratoDTO> selectAll(PgPool pgPool) {
        var pratosQueryResult = pgPool.query("select * from prato;").execute();
        return uniToMulti(pratosQueryResult);
    }

    private static Multi<PratoDTO> uniToMulti(Uni<RowSet<Row>> pratosQueryResult) {
        return pratosQueryResult.onItem().transformToMulti(
                    rowSet -> Multi.createFrom().items(() -> StreamSupport.stream(rowSet.spliterator(), false))
                .onItem().transform(PratoDTO::from)
        );
    }
}
