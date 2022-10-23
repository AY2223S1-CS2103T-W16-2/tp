<!-- markdownlint-disable-file blanks-around-headings -->
<!-- markdownlint-disable-file first-line-h1 -->
{% assign filtered = site.glossary | where_exp: "item", "item.show-in contains include.type" %}
{% assign groups = filtered | group_by_exp: "item", "item.name | truncate: 1, ''" %}

<!-- markdownlint-disable no-inline-html -->
<table>
<thead>
  <td>Quick Reference</td>
</thead>
<!-- TODO: We need to manually check that the links work -->
{% tablerow entry in filtered %}
<a href="#{{ entry.name | slugify }}">{{ entry.name }}</a>
{% endtablerow %}
</table>
{: .glossary-quick-reference }
<!-- markdownlint-enable no-inline-html -->

{% for group in groups %}
### {{ group.name }}
{: .no_toc}

<!-- markdownlint-disable-next-line no-inline-html -->
<div markdown="1" class="glossary">
{% for entry in group.items %}
#### {{ entry.name }}
{: .no_toc}

{{ entry }}
{% endfor %}
</div>

{% endfor %}
