package mtree

given Conversion[String, MTree[Char]] = s => P70.string2MTree(s)
