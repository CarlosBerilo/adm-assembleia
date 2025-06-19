package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.Voto;

public interface VotoDataPort {
    Voto votar(Voto voto);
}
