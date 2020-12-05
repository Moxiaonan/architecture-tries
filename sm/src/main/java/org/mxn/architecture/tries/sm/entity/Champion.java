package org.mxn.architecture.tries.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Champion {
    private Integer id;
    private String name;
    private String year;
}
