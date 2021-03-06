/*
 * Knowage, Open Source Business Intelligence suite
 * Copyright (C) 2016 Engineering Ingegneria Informatica S.p.A.
 *
 * Knowage is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Knowage is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.eng.knowage.meta.model.business;

import java.util.Set;

import it.eng.knowage.meta.exception.KnowageMetaException;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Calculated Business Column</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see it.eng.knowage.meta.model.business.BusinessModelPackage#getCalculatedBusinessColumn()
 * @model
 * @generated
 */
public interface CalculatedBusinessColumn extends BusinessColumn {

	Set<SimpleBusinessColumn> getReferencedColumns() throws KnowageMetaException;
} // CalculatedBusinessColumn
